
import numpy as np
import cv2

img = np.zeros((512, 512,3), np.uint8)
img = cv2.line(img, (0, 0), (511,511), (255,0,0),5 )
img = cv2.rectangle(img, (100,100), (500,300), (0,255,0) , 1)
img = cv2.circle(img, (300,300), 100, (0,0,255), -2)
img = cv2.ellipse(img, (256,256), (100,70), 0, 0, 180, (0,255,0), -1)

cv2.putText(img, "hello world", (10,500), cv2.FONT_HERSHEY_SIMPLEX, 2, (255,255,255), 2)
cv2.imshow('image', img)
cv2.waitKey(0)
cv2.destroyAllWindows()
