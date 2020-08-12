import cv2
import numpy as np

img1= cv2.imread('logos.jpg')
img2 = cv2.imread('lena1.jpg')

cv2.imshow('original', img1)

rows, cols, channels = img1.shape

roi = img2[0:rows, 0:cols]

cv2.imshow('roi', roi)

img2gray = cv2.cvtColor(img1, cv2.COLOR_BGR2GRAY)
cv2.imshow('gray', img2gray)
ret, mask = cv2.threshold(img2gray, 10, 255, cv2.THRESH_BINARY)
mask_inv = cv2.bitwise_not(mask)
cv2.imshow('mask', mask)
img1_fg = cv2.bitwise_and(img1, img1, mask=mask)
img2_bg = cv2.bitwise_and(roi, roi, mask=mask_inv)

dst = cv2.add(img1_fg, img2_bg)

img2[0:rows, 0:cols] = dst

cv2.imshow('res', img2)
cv2.waitKey(0)
cv2.destroyAllWindows()
