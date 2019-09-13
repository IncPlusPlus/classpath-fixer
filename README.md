# classpath-fixer
[![Build Status](https://travis-ci.com/IncPlusPlus/classpath-fixer.svg?branch=master)](https://travis-ci.com/IncPlusPlus/classpath-fixer)

This will overwrite the library JARs linked to by an IntelliJ .iml project with specific JARs linked to by a .classpath file. Any JARs in the .classpath that begin with a given prefix (default is "bundle") will have their MANIFEST files examined. All of the JARs linked to by the manifests of the discovered prefixed JARs will get dumped into the IntelliJ .iml that sits next to the classpath.

## Getting started
Clone this repository in IntelliJ and open it as a new Maven project when prompted. Create a new run configuration for the Main class and in the arguments, put the directory where you have both an .iml and .classpath on the same level that you want to be synced up. For my Rocket people out there, this would be the path to your bundle folder. You're all set. Give it a whirl!
