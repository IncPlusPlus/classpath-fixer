# classpath-fixer
[![Build Status](https://travis-ci.com/IncPlusPlus/classpath-fixer.svg?branch=master)](https://travis-ci.com/IncPlusPlus/classpath-fixer)

## What is this?
This will overwrite the library JARs linked to by an IntelliJ .iml project with specific JARs linked to by a .classpath file. Any JARs in the .classpath that begin with a given prefix (default is "bundle") will have their MANIFEST files examined. All of the JARs linked to by the manifests of the discovered prefixed JARs will get dumped into the IntelliJ .iml that sits next to the classpath.

## Why?

In Eclipse, if a JAR is included in a project's `.classpath` as a `<classpathentry exported="true" kind="lib"...>`, any classes within the JAR are added to the build and runtime classpath. **Additionally**, any JARs named in the `MANIFEST.MF` under the `Class-Path` attribute of that JAR are *also* added to the classpath. It's this last feature that IntelliJ doesn't support. For details, see [IDEA-130132](https://youtrack.jetbrains.com/issue/IDEA-130132) and [IDEABKL-6988](https://youtrack.jetbrains.com/issue/IDEABKL-6988).

My workplace currently leverages this behavior in Eclipse. We have JARs that start with a prefix and are kept on Eclipse's `.classpath`. Their only content is a `MANIFEST.MF` with list of JARs that should be included in the classpath of the Eclipse environment under the `Class-Path` attribute. As an IntelliJ user, this means I have to manually keep my environment in sync with with their Eclipse environment. This is completely unsustainable. This tool is a fancy band-aid for this problem. Currently, it only grabs the JARs that have the special prefix in its name. My goal for this project is to eventually be able to generate or at least synchronise more of the aspects of the `.classpath` to an `.iml` like inclusion/exclusion.

This project is a bit of a hack because it parses `.classpath` and `.iml` files and manually manipulates `.iml` files. There are a bunch of safety mechanisms in place to prevent this from causing a corrupted `.iml` files but it is still inherently risky to be editing these instead of changing the settings through the GUI of IntelliJ.

I haven't had the time to learn how to create IntelliJ plugins but this project should absolutely be an IntelliJ plugin. This would still involve parsing a `.classpath`. However, there would no longer be manipulation of `.iml` files because my plugin would have access to the settings of the IntelliJ environment. This is *leagues* safer because it is using proper APIs made by JetBrains.

This project may not work for all `.classpath` and `.iml` files. There are almost certainly missing XML attributes for both of these types of files. Since there is no public schema for either of these formats, I haven't found a good comprehensive source that lists all of the possible attributes for either. If you come across an missing attribute, feel free to submit a new bug ticket on the issues tab.

## Getting started
Clone this repository in IntelliJ and open it as a new Maven project when prompted. Create a new run configuration for the Main class and in the arguments, put the directory where you have both an .iml and .classpath on the same level that you want to be synced up. For my Rocket people out there, this would be the path to your bundle folder. You're all set. Give it a whirl!
