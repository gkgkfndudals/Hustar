
import cv2
import numpy as np

img = cv2.imread('image.jpg')

while(1):
    
    hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)

    cv2.imshow('hsv', hsv)

    lower_blue = np.array([110, 50, 50])
    upper_blue=np.array([130, 255, 255])

    mask = cv2.inRange(hsv, lower_blue, upper_blue)

    res= cv2.bitwise_and(img, img, mask=mask)

    cv2.imshow('img', img)
    cv2.imshow('mask', mask)
    cv2.imshow('res', res)

    if cv2.waitKey(1) & 0xFF == 27:
        break;


cv2.destroyAllWindows()