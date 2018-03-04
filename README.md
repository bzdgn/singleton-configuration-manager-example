Singleton Configuration Manager Example
=======================================
This is the Configuration Manager class I've written a long time ago to use as a general
config manager in my projects. It is a simple Gang-Of-Four Singleton design pattern.
With this simple class, you can use the properties file and access it with this
single singleton configuration manager.

Properties File
---------------
There are two locations that properties file can be located;

1- Properties file can be either on the base dir, or if you are using a build tool like maven,
it can be in the resource directory (which is: src/main/resources).

2- If an environmental variable is defined, then the value of the env-variable will be the
location of the properties file.

The logic is simple, the program first checks whether an environmental variable is defined.
If so, it will check if there is a file on the value of the environmental variable which is
actually the location of the directory. If there is the file, then config-manager is going
to use it, if not, it will System.exit(1).

If the environmental variable is not set, the config-manager will check the base dir, or the
base resource directory to check whether if there is a properties file. If it is in there,
it will use it, if not, again, it will System.exit(1).

The name of the properties file is hardcoded inside the ConfigManager class.

Setting Up The Environmental Variable
-------------------------------------
You can set up the environmental variable in windows as below;

![alt picturehere](http://url/to/img.png)

If the env-variable is set, then inside the Config static class which is inside the ConfigManager,
you can hardcode the name of the environmental variable.

States Of The ConfigManager
---------------------------
1- Environmental Variable Set But There Is No Properties File In The Target Location

![alt picturehere](http://url/to/img.png)

2- Environmental Variable Set And There Is Properties File In The Target Location

![alt picturehere](http://url/to/img.png)

3- Environmental Variable Is Not Set And There Is Properties File In The Base Dir

![alt picturehere](http://url/to/img.png)

4- Environmental Variable Is Not Set And No Properties File In The Base Dir

![alt picturehere](http://url/to/img.png)

