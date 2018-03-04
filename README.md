Singleton Configuration Manager Example
=======================================
This is the Configuration Manager class I've written a long time ago to use as a general
config manager in my projects. It is a simple Gang-Of-Four Singleton design pattern.
With this simple class, you can use the properties file and access it with this
single singleton configuration manager.

TOC
---
1- [Properties File](#properties-file) <br/>
2- [Setting Up The Environmental Variable](#setting-up-the-environmental-variable) <br/>
3- [States Of The ConfigManager](#states-of-the-configmanager) <br/>

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

[Go back to TOC](#toc)

Setting Up The Environmental Variable
-------------------------------------
You can set up the environmental variable in windows as below;

![Setting-Up-Environmental-Variable](https://raw.githubusercontent.com/bzdgn/singleton-configuration-manager-example/master/ScreenShots/00_HOW_TO_SET_ENV_VAR.PNG)

If the env-variable is set, then inside the Config static class which is inside the ConfigManager,
you can hardcode the name of the environmental variable.

[Go back to TOC](#toc)

States Of The ConfigManager
---------------------------
1- Environmental Variable Set But There Is No Properties File In The Target Directory

![Env-Is-Set-But-No-Props-File-In-Target-Dir](https://raw.githubusercontent.com/bzdgn/singleton-configuration-manager-example/master/ScreenShots/01_ENV_IS_SET_BUT_NO_FILE.PNG)

2- Environmental Variable Set And There Is Properties File In The Target Directory

![Env-Is-Set-But-Props-File-In-Target-Dir](https://raw.githubusercontent.com/bzdgn/singleton-configuration-manager-example/master/ScreenShots/02_ENV_IS_SET_AND_FILE_IS_FOUND.PNG)

3- Environmental Variable Is Not Set And There Is Properties File In The Base Dir

![Env-Is-Not-Set-But-Props-File-In-Base-Dir](https://raw.githubusercontent.com/bzdgn/singleton-configuration-manager-example/master/ScreenShots/03_NO_ENV_IS_SET_FILE_IS_ON_WORKING_DIR.PNG)

4- Environmental Variable Is Not Set And No Properties File In The Base Dir

![Env-Is-Not-Set-And-No-Props-File-In-Base-Dir](https://raw.githubusercontent.com/bzdgn/singleton-configuration-manager-example/master/ScreenShots/04_NO_ENV_IS_SET_FILE_IS_NOT_FOUND_ON_WORKING_DIR.PNG)

[Go back to TOC](#toc)

