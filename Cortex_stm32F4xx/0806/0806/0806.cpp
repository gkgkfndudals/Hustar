// ConsoleApplication1.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
// 0b10101111;
typedef unsigned int u32;
typedef unsigned char u8;
void my_print_bin_8(unsigned char t) {
	printf("0b");
	for (int i = 0; i < 8; i++) {
		int digit = t / pow(2, 7);
		t = t << 1;
		printf("%d", digit);
	}printf("\n");
}

void my_print_bin_32(unsigned int t) {
	printf("0b");

	for (int i = 0; i < 32; i++) {
		int digit = t / pow(2,31);
		t = t << 1;
		printf("%d", digit);
	}
	printf("\n");
}

void my_print_bin32to8(unsigned int t) {
	//printf("0b");
	unsigned char a = 0, b = 0, c = 0, d = 0;

	for (int i = 0; i < 32; i++) {
		int digit = t / pow(2, 31);
		t = t << 1;
		
		if (0<=i && i<8) {
			a = a + digit;
			if (i == 7) {
				continue;
			}
			a = a << 1;
			
		}
		else if (8 <= i && i < 16) {
			b = b + digit;
			if (i == 15) {
				continue;
			}
			b = b << 1;
		}
		else if (16 <= i && i < 24) {
			c = c + digit;
			if (i == 23) {
				continue;
			}
			c = c << 1;
		}
		else if (24 <= i && i < 32) {
			d = d + digit;
			if (i == 31) {
				continue;
			}
			d= d << 1;
		}

	}
	
	printf("\n\n");
	printf("a: %d\n", a);
	printf("b: %d\n", b);
	printf("c: %d\n", c);
	printf("d: %d\n", d);

	my_print_bin_8(a);
	my_print_bin_8(b);
	my_print_bin_8(c);
	my_print_bin_8(d);
	

	
	printf("\n");
}

void teacher_print_bin32to8(u32 tmp) {
	u8 a = tmp & 0b11111111; tmp >>= 8;
	u8 b = tmp & 0b11111111; tmp >>= 8;
	u8 c = tmp & 0b11111111; tmp >>= 8;
	u8 d = tmp & 0b11111111; tmp >>= 8;

	//u8 a = tmp / (1 << 24); tmp <<= 8;
	//u8 b = tmp / (1 << 24); tmp <<= 8;
	//u8 c = tmp / (1 << 24); tmp <<= 8;
	//u8 d = tmp / (1 << 24); tmp <<= 8;

	printf("1번째 바이트: ");
	my_print_bin_8(a);

	printf("2번째 바이트: ");
	my_print_bin_8(b);

	printf("3번째 바이트: ");
	my_print_bin_8(c);

	printf("4번째 바이트: ");
	my_print_bin_8(d);
}

void my_print_bin8sto32(u8 *a) {
	u32 result;

	
	u32 temp0, temp1, temp2, temp3;

	temp0 = a[0];
	temp0 = temp0 << 24;

	temp1 = a[1];
	temp1 = temp1 << 16;

	temp2 = a[2];
	temp2 = temp2 << 8;

	temp3 = a[3];
	temp3 = temp3 << 0;

	result = temp0 | temp1 | temp2 | temp3;

	

	my_print_bin_32(result);
}

void teacher_print_bin8sto32(u8 *a) {
	u32 res = 0;
	for (int i = 0; i < 4; i++) {
		res <<= 8;
		res += a[i];
	}
	my_print_bin_32(res);
}

int my_read_pin4(u8 a) {
	a &= 0b00001000;
	a >>= 3;
	return a;
}

int my_read_pin_A(u8 a, u8 pin_num) {
	pin_num -= -1;
	a &= 1 << pin_num;
	a >>= pin_num;
	return a;
}

int my_write_pin_A_3(u8 a) {  //a는 1 또는 0 입력 
	u8 others = 0b11110100;
	u8 res = 0;

	u8 add_num = a << 2;
	res = others | add_num;

	return res;

}

int main()
{
	/*
	int a = 1;
	int b = 2;
	int c = a + b;
	printf("%d\n", c);
	*/

	//unsigned char a = 0xAB;   // 171;   // 0xAB, 0b 1010 1011
	//unsigned char b = 0xFF;   // 255; // 0xFF, 0b 1111 1111
	//unsigned char c = a | b;   // 0xFF, 0b 1111 1111
	//printf("0x%x\n", c);

	//typedef unsigned char u8;

	//u8 a2 = 0xAB;   // 171;   // 0xAB, 0b 1010 1011
	//u8 b2 = 0xFF;   // 255; // 0xFF, 0b 1111 1111
	//u8 c2 = a2 | b2;      // 0xFF, 0b 1111 1111
	//printf("0x%x\n", c2);

	//u8 a3 = 0x10101011;   // 171;   // 0xAB, 0b 1010 1011
	//u8 b3 = 0xFF;   // 255; // 0xFF, 0b 1111 1111
	//u8 c3 = a3 | b3;      // 0xFF, 0b 1111 1111
	//printf("0x%x\n", c3);

	unsigned char tmp = 0b10101111;
	unsigned int tmp1 = 0b10101111000100111111111000010110;
	u8 x[4] = { 0b11110000, 0b10101010, 0b01010101, 0b11001100 };

	my_print_bin_8(tmp);
	printf("\n");
	my_print_bin_32(tmp);
	printf("\n");
	my_print_bin32to8(tmp1);
	printf("\n");
	teacher_print_bin32to8(tmp1);
	printf("\n");
	my_print_bin8sto32(x);
	printf("\n");


	u8 a = 0b00000001;
	for (int i = 0; i < 10; i++) {
		a ^= 1;
		printf("%d\n", a);
		/*
		if (a == 1) {
			printf("%d\n", a);
			a = 0;
		}
		else {
			printf("%d\n", a);
			a = 1;
		}
		*/
	}

	printf("\n");
	u8 n = 0b10101111;
	printf("my_read_pin4: %d\n" , my_read_pin4(n));

	printf("\n");
	printf("my_read_pin_A: %d\n", my_read_pin_A(n, 4));

	printf("\n");
	u8 result = my_write_pin_A_3(0);
	printf("my_write_pin_A: ");
	my_print_bin_8(result);
	

}
