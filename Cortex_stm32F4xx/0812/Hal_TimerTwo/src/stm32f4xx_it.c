#include "stm32f4xx_hal.h"
#include "stm32f4xx_it.h"

extern TIM_HandleTypeDef TimHandle2, TimHandle3;
void TIM2_IRQHandler(void)
{
	HAL_TIM_IRQHandler(&TimHandle2);// TIM 인터럽트 Callback 함수
}

void TIM3_IRQHandler(void)
{
	HAL_TIM_IRQHandler(&TimHandle3);// TIM 인터럽트 Callback 함수
}

