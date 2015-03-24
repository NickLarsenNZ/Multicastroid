# Multicastroid
Command Line Multicast Testing Tool

## Contribution
Thanks to the author (Nguonly Taing) of the article: http://lycog.com/programming/multicast-programming-java/ as well as the Oracle Java documentation.

## Usage

### Defaults
- Group: 239.255.0.1
- Port: 1984
- Interval: 800ms [sender only]
- IPv4 Time-To-Live: 1 [sender only]

### Multicast Sender
To send to the multicast group 239.192.0.1 on port 8000 every 500ms allowing one router hop:
```java -jar Multicastroid.jar -m send -g 239.192.0.1 -p 8000 -i 500 -t 2```

### Multicast Receiver
To receive the above traffic
```java -jar Multicastroid.jar -m join -g 239.192.0.1 -p 8000```
