#include "stm32f4xx_hal.h"
#include "stm32f4xx_it.h"

extern TIM_HandleTypeDef TimHandle;
void TIM2_IRQHandler(void)
{
	HAL_TIM_IRQHandler(&TimHandle); // TIM ���ͷ�Ʈ Callback �Լ�
}