/*
 * This file is part of the µOS++ distribution.
 *   (https://github.com/micro-os-plus)
 * Copyright (c) 2014 Liviu Ionescu.
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

// ----------------------------------------------------------------------------
#include <stdio.h>
#include <stdlib.h>
#include "diag/Trace.h"

#include "Timer.h"
#include "BlinkLed.h"

// ----------------------------------------------------------------------------
//
// Standalone STM32F4 led blink sample (trace via ITM).
//
// In debug configurations, demonstrate how to print a greeting message
// on the trace device. In release configurations the message is
// simply discarded.
//
// Then demonstrates how to blink a led with 1 Hz, using a
// continuous loop and SysTick delays.
//
// Trace support is enabled by adding the TRACE macro definition.
// By default the trace messages are forwarded to the ITM output,
// but can be rerouted to any device or completely suppressed, by
// changing the definitions required in system/src/diag/trace_impl.c
// (currently OS_USE_TRACE_ITM, OS_USE_TRACE_SEMIHOSTING_DEBUG/_STDOUT).
//

// ----- Timing definitions -------------------------------------------------

// Keep the LED on for 2/3 of a second.
#define BLINK_ON_TICKS  (TIMER_FREQUENCY_HZ * 3 / 4)
#define BLINK_OFF_TICKS (TIMER_FREQUENCY_HZ - BLINK_ON_TICKS)

// ----- main() ---------------------------------------------------------------

// Sample pragmas to cope with warnings. Please note the related line at
// the end of this function, used to pop the compiler diagnostics status.
#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wunused-parameter"
#pragma GCC diagnostic ignored "-Wmissing-declarations"
#pragma GCC diagnostic ignored "-Wreturn-type"

#include "stm32f4xx_hal.h"
#include "stm32f4xx_it.h"
TIM_HandleTypeDef TimHandle2, TimHandle3;
GPIO_InitTypeDef LED;
void TIMER2_Config() {
	__HAL_RCC_TIM2_CLK_ENABLE()
	;
	TimHandle2.Instance = TIM2;
	//42MHz 4200 0000Hz
	TimHandle2.Init.Period = 10000 - 1; // 0~9999(ARR) 10000��
	TimHandle2.Init.Prescaler = 8400 - 1;
	TimHandle2.Init.ClockDivision = TIM_CLOCKDIVISION_DIV1;
	TimHandle2.Init.CounterMode = TIM_COUNTERMODE_DOWN;
	HAL_TIM_Base_Init(&TimHandle2);

	HAL_TIM_Base_Start_IT(&TimHandle2);

	HAL_NVIC_SetPriority(TIM2_IRQn, 0, 0);
	HAL_NVIC_EnableIRQ(TIM2_IRQn);

}

void TIMER3_Config() {
	__HAL_RCC_TIM3_CLK_ENABLE()
	;
	TimHandle3.Instance = TIM3;
	//42MHz 4200 0000Hz
	TimHandle3.Init.Period = 5000 - 1; // 0~9999(ARR) 10000��
	TimHandle3.Init.Prescaler = 8400 - 1;
	TimHandle3.Init.ClockDivision = TIM_CLOCKDIVISION_DIV1;
	TimHandle3.Init.CounterMode = TIM_COUNTERMODE_DOWN;
	HAL_TIM_Base_Init(&TimHandle3);

	HAL_TIM_Base_Start_IT(&TimHandle3);

	HAL_NVIC_SetPriority(TIM3_IRQn, 0, 0);
	HAL_NVIC_EnableIRQ(TIM3_IRQn);

}

void HAL_TIM_PeriodElapsedCallback(TIM_HandleTypeDef* htim) {
	if (htim->Instance == TimHandle2.Instance)
		HAL_GPIO_TogglePin(GPIOC, GPIO_PIN_2);
	else if (htim->Instance == TimHandle3.Instance)
		HAL_GPIO_TogglePin(GPIOC, GPIO_PIN_3);

//	HAL_GPIO_TogglePin(GPIOC, GPIO_PIN_2);
//	HAL_GPIO_TogglePin(GPIOC, GPIO_PIN_3);
	HAL_GPIO_TogglePin(GPIOC, GPIO_PIN_4);
}
int main(int argc, char* argv[]) {
	__HAL_RCC_GPIOC_CLK_ENABLE()
	;
	LED.Pin = GPIO_PIN_2 | GPIO_PIN_3 | GPIO_PIN_4;
	LED.Mode = GPIO_MODE_OUTPUT_PP;
	LED.Pull = GPIO_NOPULL;
	LED.Speed = GPIO_SPEED_LOW;
	HAL_GPIO_Init(GPIOC, &LED);

	TIMER2_Config();
	TIMER3_Config();

	while (1) {
	}
}

#pragma GCC diagnostic pop

// ----------------------------------------------------------------------------
