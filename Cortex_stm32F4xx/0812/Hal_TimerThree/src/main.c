/*
 * This file is part of the 쨉OS++ distribution.
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


#define BLINK_ON_TICKS  (TIMER_FREQUENCY_HZ * 3 / 4)
#define BLINK_OFF_TICKS (TIMER_FREQUENCY_HZ - BLINK_ON_TICKS)

// ----- main() ---------------------------------------------------------------

// Sample pragmas to cope with warnings. Please note the related line at
// the end of this function, used to pop the compiler diagnostics status.
#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wunused-parameter"
#pragma GCC diagnostic ignored "-Wmissing-declarations"
#pragma GCC diagnostic ignored "-Wreturn-type"


TIM_HandleTypeDef TimHandle;
TIM_HandleTypeDef TimHandle3;
GPIO_InitTypeDef LED;
TIM_OC_InitTypeDef TIM_OCInit;
GPIO_InitTypeDef GPIO_Init_Struct;

void LED_config()
{
	__HAL_RCC_GPIOC_CLK_ENABLE();

	LED.Pin = GPIO_PIN_2 | GPIO_PIN_3;
	LED.Mode = GPIO_MODE_OUTPUT_PP;
	LED.Pull= GPIO_PULLUP;
	LED.Speed = GPIO_SPEED_FREQ_HIGH;
	HAL_GPIO_Init(GPIOC, &LED);

}

void TIMER_Config()
{
	//범용 타이머
	__HAL_RCC_TIM2_CLK_ENABLE();
	TimHandle.Instance = TIM2;
	TimHandle.Init.Period = 10000-1;
	TimHandle.Init.Prescaler = 8400-1;
	TimHandle.Init.ClockDivision = TIM_CLOCKDIVISION_DIV1;
	TimHandle.Init.CounterMode = TIM_COUNTERMODE_UP;
	HAL_TIM_Base_Init(&TimHandle);
	HAL_TIM_Base_Start_IT(&TimHandle);

	//OC
	TIM_OCInit.OCMode = TIM_OCMODE_TIMING;
	TIM_OCInit.Pulse = 2000-1;
	TIM_OCInit.OCPolarity = TIM_OCPOLARITY_LOW;
	TIM_OCInit.OCFastMode = TIM_OCFAST_DISABLE;
	HAL_TIM_OC_Init(&TimHandle);
	HAL_TIM_OC_ConfigChannel(&TimHandle, &TIM_OCInit, TIM_CHANNEL_1);
	HAL_TIM_OC_Start_IT(&TimHandle, TIM_CHANNEL_1);

	HAL_NVIC_SetPriority(TIM2_IRQn, 0, 0);
	HAL_NVIC_EnableIRQ(TIM2_IRQn);



}



void HAL_TIM_PeriodElapsedCallback(TIM_HandleTypeDef* htim)
{

		HAL_GPIO_WritePin(GPIOC, GPIO_PIN_2,1);
		HAL_GPIO_WritePin(GPIOC, GPIO_PIN_3,1);


	//HAL_GPIO_TogglePin(GPIOC, GPIO_PIN_4);

}
void HAL_TIM_OC_DelayElapsedCallback(TIM_HandleTypeDef* htim)
{
	HAL_GPIO_WritePin(GPIOC, GPIO_PIN_2,0);

	HAL_GPIO_WritePin(GPIOC, GPIO_PIN_3,0);

}



int  main(int argc, char* argv[])
{
	LED_config();

	TIMER_Config();


  // Infinite loop
  while (1)
    {

    }
  // Infinite loop, never return.
}

#pragma GCC diagnostic pop

// ----------------------------------------------------------------------------
