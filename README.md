# Sloth

### TODO
1. Make the shooter a PID loop that controls the value going to the motor. It needs to be activated when you hit one of the buttons and goes to a certain speed based on the speed that the encoder returns.
2. Alignment. GRIP will output some value to NetworkTables, we only need to send the X coordinate to turn towards it. Figure out how off-center that value is and plug it into a PID loop and output as rotation (MecanumDrive_Polar()).

### Controller Input Map
![Controller Input Map](gamepad_input.png?raw=true)

### Samarth's Stupid MS Paint Thing
![Samarth Sucks](samarth.png?raw=true)
