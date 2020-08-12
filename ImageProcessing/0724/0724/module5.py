
import cv2
import numpy as np
from matplotlib import pyplot as plt

img = cv2.imread('pers.jpg', cv2.IMREAD_COLOR)

pts1= np.float32([[94,185],[42,283],[185,182],[237,314]])
pts2 = np.float32([[10,10], [10,1000], [1000, 10], [1000,1000]])

cv2.imshow('aa', img)

M=cv2.getPerspectiveTransform(pts1, pts2)

dst= cv2.warpPerspective(img, M, (1100, 1100))

plt.subplot(121), plt.imshow(img), plt.title('image')
plt.subplot(122), plt.imshow(dst), plt.title('perspective')
plt.show()