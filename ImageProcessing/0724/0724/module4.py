
import cv2
import numpy as np
from matplotlib import pyplot as plt

img = cv2.imread("Fig0504(i)(salt-pepper-noise).tif", cv2.IMREAD_GRAYSCALE)

ret1, th1 = cv2.threshold(img, 110, 255, cv2.THRESH_BINARY)
ret2, th2 = cv2.threshold(img, 0, 255, cv2.THRESH_BINARY + cv2.THRESH_OTSU)

blur = cv2.GaussianBlur(img, (7,7), 0)

ret3, th3 = cv2.threshold(blur, 0, 255,cv2.THRESH_BINARY+cv2.THRESH_OTSU)

images= [img, 0, th1, img, 0, th2, blur, 0 , th3]

titles = [ 'Original Noisy image', 'histogram', 'global thresholding(v=110)', 'Original Noisy Image', 'Histogram', "otsu's thresholding", "gaussian filtered image", 'histogram', "otsu's Thresholding"]

for i in range(3) :
    plt.subplot(3,3, i*3+1), plt.imshow(images[i*3], 'gray')
    plt.title(titles[i*3]), plt.xticks([]), plt.yticks([])
    plt.subplot(3,3, i*3+2), plt.hist(images[i*3].ravel(),256)
    plt.title(titles[i*3+1]), plt.xticks([]), plt.yticks([])
    plt.subplot(3,3, i*3+3), plt.imshow(images[i*3+2], 'gray')
    plt.title(titles[i * 3+2]), plt.xticks([]), plt.yticks([])



plt.show()