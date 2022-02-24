# Android_Phone_Sensor_Data_Representation
# Goal
To create an android app that collects data from the accelerometer, gyroscope and proximity sensor of the android device it is running on. This data is then displayed by illuminating LED's depending on the magnitude of the sensor values.

# App Functionality
As seen in Video 1. The application lets the user choose the sensor from which the data has to be collected.

# Accelerometer
There is a 3-axis accelerometer present in most of the android devices. Whenever the device is moved this accelerometer captures the acceleration of the movement. The app captures this acceleration in all the axis and after RMS calculation of the acceleration on all three axis it provides a magnitude of the acceleration. This magnitude is then displayed using 7 LED's using threshold values produced by trial-error method

# Gyroscope
The gyroscope present in the android devices are also 3-axis but in this project only the z-axis data was used. The gyroscope provides angular velocity values when the device is rotated on any axis. To show the rotation of the phone these angular velocity values are multiplied by time in order to produce the angle by which the phone is rotated. This app can detect rotation in both clockwise and anti-clockwise direction. The angle of rotation is displayed using 3 LED's on each side of the center LED. The more the angle of rotation the more number of LED's will light up.

# Proximity
Proximity sensor is used in a phone to detect when the users face is near the phone while on a call. This is then used to switch-off the display to avoid accidental touches. Proximity sensor gives out binary values. Therefore this app illuminates all the 7 LED's if the proximity sensor detects something. If nothing is detected then no lED's are illuminated.

# Challenges
The major challenge faced by me in this project was that the sensors were giving out data at 200Hz. Due to this the LED's were illuminated for a very short time which was difficult for the user to see. To overcome this challenge I created a filter to pass only the values that I required.
