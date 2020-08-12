#include "stm32f4xx_hal.h"

void EXIT2_IRQHandler(void){
	HAL_GPIO_EXTI_IRQHandler(GPIO_PIN_2);
}
