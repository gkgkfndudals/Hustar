/*
 * This file is part of the ÂµOS++ distribution.
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

#include "stm32f4xx.h"

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

void my_ms_delay_int_count(volatile unsigned int n) {
	for (n *= 14000; n > 0; n--)
		;
}

void my_us_delay_int_count(volatile unsigned int n) {
	for (n *= 14; n > 0; n--)
		;
}
// 0:do(262Hz, 3800us) 1:re 294, 3401us 2:mi 330, 3030us 3:fa 349, 2865us
// 4:sol 392, 2551us  5: ra 440, 2272us  6:ti 494, 2024us  7:do 523, 1912us
void playNote(int note) {
	if (note == 0) {
		// do 1900us on 1900us off 200È¸ ¹Ýº¹(0.8ÃÊ)
		for (int t = 0; t < 200; t++) {
			GPIOB->ODR = 0x8000;
			my_us_delay_int_count(1900);
			GPIOB->ODR = 0x0000;
			my_us_delay_int_count(1900);
		}
		// off (0.2)
		GPIOB->ODR = 0x0000;
		my_ms_delay_int_count(200);
	} else if (note == 1) {
		for (int t = 0; t < 200; t++) {
			GPIOB->ODR = 0x8000;
			my_us_delay_int_count(1700);
			GPIOB->ODR = 0x0000;
			my_us_delay_int_count(1700);
		}
		// off (0.2)
		GPIOB->ODR = 0x0000;
		my_ms_delay_int_count(200);
	} else if (note == 2) {
		for (int t = 0; t < 200; t++) {
			GPIOB->ODR = 0x8000;
			my_us_delay_int_count(1515);
			GPIOB->ODR = 0x0000;
			my_us_delay_int_count(1515);
		}
		// off (0.2)
		GPIOB->ODR = 0x0000;
		my_ms_delay_int_count(200);
	} else if (note == 3) {
		for (int t = 0; t < 200; t++) {
			GPIOB->ODR = 0x8000;
			my_us_delay_int_count(1433);
			GPIOB->ODR = 0x0000;
			my_us_delay_int_count(1433);
		}
		// off (0.2)
		GPIOB->ODR = 0x0000;
		my_ms_delay_int_count(200);
	} else if (note == 4) {
		for (int t = 0; t < 200; t++) {
			GPIOB->ODR = 0x8000;
			my_us_delay_int_count(1276);
			GPIOB->ODR = 0x0000;
			my_us_delay_int_count(1276);
		}
		// off (0.2)
		GPIOB->ODR = 0x0000;
		my_ms_delay_int_count(200);
	} else if (note == 5) {
		for (int t = 0; t < 200; t++) {
			GPIOB->ODR = 0x8000;
			my_us_delay_int_count(1136);
			GPIOB->ODR = 0x0000;
			my_us_delay_int_count(1136);
		}
		// off (0.2)
		GPIOB->ODR = 0x0000;
		my_ms_delay_int_count(200);
	} else if (note == 6) {
		for (int t = 0; t < 200; t++) {
			GPIOB->ODR = 0x8000;
			my_us_delay_int_count(1012);
			GPIOB->ODR = 0x0000;
			my_us_delay_int_count(1012);
		}
		// off (0.2)
		GPIOB->ODR = 0x0000;
		my_ms_delay_int_count(200);
	} else if (note == 7) {
		for (int t = 0; t < 200; t++) {
			GPIOB->ODR = 0x8000;
			my_us_delay_int_count(956);
			GPIOB->ODR = 0x0000;
			my_us_delay_int_count(956);
		}
		// off (0.2)
		GPIOB->ODR = 0x0000;
		my_ms_delay_int_count(200);
	}

}

int main(int argc, char* argv[]) {
	RCC->AHB1ENR = 0x00000002;
	GPIOB->MODER = 0x40000000;
	GPIOB->OTYPER = 0;
	GPIOB->PUPDR = 0;
	GPIOB->OSPEEDR = 0;

	unsigned int period, buf;

	while (1) {
		playNote(0);
		playNote(1);
		playNote(2);
		playNote(3);
		playNote(4);
		playNote(5);
		playNote(6);
		playNote(7);
	}
	// Infinite loop, never return.
}

#pragma GCC diagnostic pop

// ----------------------------------------------------------------------------
