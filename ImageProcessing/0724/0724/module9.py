import cv2
import numpy as np

img= cv2.imread('image.jpg')
imgray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

ret, thresh = cv2.threshold(imgray , 230, 255, 0)

contours, hierachy = cv2.findContours(thresh, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
image = cv2.drawContours(img, contours, -1, (0,255,0), 3)

cv2.imshow("thresh", thresh)

cv2.imshow('image', image)
cv2.waitKey(0)
cv2.destroyAllWindows()
