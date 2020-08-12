
import cv2
import numpy as np
from matplotlib import pyplot as plt

img = cv2.imread('image.jpg', cv2.IMREAD_GRAYSCALE)
th=150
th_max = 255

ret1, thresh1 = cv2.threshold(img, th, th_max, cv2.THRESH_BINARY)
ret2, thresh2 = cv2.threshold(img, th, th_max, cv2.THRESH_BINARY_INV)
ret3, thresh3 = cv2.threshold(img, th, th_max, cv2.THRESH_TRUNC)
ret4, thresh4 = cv2.threshold(img, th, th_max, cv2.THRESH_TOZERO)
ret5, thresh5 = cv2.threshold(img, th, th_max, cv2.THRESH_TOZERO_INV)
#ret1, thresh1 = cv2.threshold(img, th, th_max, cv2.THRESH_BINARY)

titles = ['Original', 'BINARY' ,'BINARY_INV', ' TRUNC' ,' TOZERO', 'TOZERO_INV']
images= [img,thresh1, thresh2, thresh3, thresh4, thresh5]

for i in range(6):
    plt.subplot(2, 3, i+1)
    plt.imshow(images[i], 'gray')
    plt.title(titles[i])
    plt.xticks([])
    plt.yticks([])


plt.show()