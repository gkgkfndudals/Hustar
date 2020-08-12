import numpy as np
import cv2

img_color = cv2.imread('lena1.jpg')

count = 0
height, width, channel = img_color.shape
img_gray = np.zeros((height, width), np.uint8)

print( height, width, channel)   # = print img_color.shape

for y in range(0, height):
    for x in range(0, width):
        b = img_color.item(y, x, 0)
        g = img_color.item(y, x, 1)
        r = img_color.item(y, x, 2)

        gray = (int(b) + int(g) + int(r)) / 3.0

        if gray > 255:
            gray = 255

        img_gray.itemset(y, x, gray) 
##여기 까지가 일반 gray scale로 변환하는 코드 구글링하면 나온다.



##여기 까지가 나머지 3/4 영역을 blue color로 바꾸는 코드..인데 잘 모르겠다.

cv2.imshow('color image', img_color)
cv2.imshow('gray image', img_gray)

cv2.imwrite('result.jpg', img_gray)

cv2.waitKey(0)
cv2.destroyAllWindows()