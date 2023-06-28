 #Simple python script that uses a moisture sensor and inserts values into local sqlite3 table
 #Used for raspberry pie project through my college computer science club that I founded
 #!/usr/bin/python
import spidev
import os
import sys
import time
import sqlite3 as mydb


spi = spidev.SpiDev()
spi.open(0,0)
spi.max_speed_hz=1000000

def readChannel(channel):
        val = spi.xfer2([1,(8+channel)<<4,0])
        data = ((val[1]&3) << 8) + val[2]
        return data

if __name__ == "__main__":
        con=mydb.connect('/home/pi/moist.db')
        with con:
                try:
                        val1 = readChannel(0)   #averages values 
                        time.sleep(2)
                        val2 = readChannel(0)
                        time.sleep(2)
                        val3 = readChannel(0)
                        val = (val1+val2+val3)/3
                        print (val)
                        if (val != 0):
                                print (val)
                                currentTime=time.strftime('%x %X %Z')
                                cur=con.cursor()
                                #sql="insert into MoistData values(?,?)"
                                cur.execute('insert into MoistData values(?,?)', (val, curre>
                except:
                        print ("Error!")

