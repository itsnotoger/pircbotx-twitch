[![](https://jitpack.io/v/itsnotoger/pircbotx-twitch.svg)](https://jitpack.io/#itsnotoger/pircbotx-twitch)

## Fork Information ##

This was forked originally back in 2016 from Pircbotx version 2.1. I then added some Twitch IRC specific features.
The only relevant branch in this project is `twitchify`, master is unchanged other than the readme.
If you should (for some reason, even though this is pretty old and not maintained) choose to use this:
```kotlin
repositories {
    mavenCentral()
    maven("https://jitpack.io")
}
dependencies {
    implementation("com.github.itsnotoger:pircbotx-twitch:2.5.0-twitchify")
}
```

## Original readme ##

**PircBotX** is a powerful and flexible Java IRC library forked from the popular PircBot framework, bringing many new up-to-date features and bug fixes in an official alternative distribution.

 * Robust, multi-threaded Event-Listener system with [over 50](http://thelq.github.io/pircbotx/latest/apidocs/org/pircbotx/hooks/events/package-summary.html) supported IRC events
 * Powerful Channel/User Model
 * Native SSL support using SSLSocket or STARTTLS
 * Standard and reverse/passive DCC Chat and Filesharing
 * CTCP VERSION, ACTION, PING, TIME, and FINGER support
 * IPv6 support
 * Support for op, voice, halfop, superops, and owner modes
 * [IRCv3 CAP negotiation](https://github.com/TheLQ/pircbotx/wiki/Documentation#cap-support) with native support for SASL, TLS, and away-notify
 * [WEBIRC](https://github.com/TheLQ/pircbotx/wiki/Documentation#webirc-authentication) support
 * Built in [Ident server](https://github.com/TheLQ/pircbotx/wiki/Documentation#ident-server)

**Checkout the [Wiki](https://github.com/TheLQ/pircbotx/wiki/) for tutorials and documentation**

##PircBotX in 3 Steps
A brief getting started guide

 * [Download PircBotX](https://github.com/TheLQ/pircbotx/wiki/Downloads)
 * Create and execute the following class:
```java
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

public class MyListener extends ListenerAdapter {
        @Override
        public void onGenericMessage(GenericMessageEvent event) {
                //When someone says ?helloworld respond with "Hello World"
                if (event.getMessage().startsWith("?helloworld"))
                        event.respond("Hello world!");
        }

        public static void main(String[] args) throws Exception {
                //Configure what we want our bot to do
                Configuration configuration = new Configuration.Builder()
                                .setName("PircBotXUser") //Set the nick of the bot. CHANGE IN YOUR CODE
                                .setServerHostname("irc.freenode.net") //Join the freenode network
                                .addAutoJoinChannel("#pircbotx") //Join the official #pircbotx channel
                                .addListener(new MyListener()) //Add our listener that will be called on Events
                                .buildConfiguration();

                //Create our bot with the configuration
                PircBotX bot = new PircBotX(configuration);
                //Connect to the server
                bot.startBot();
        }
}
```
 * Join the #pircbotx channel on irc.freenode.net and send `?helloworld` . Your bot will respond with `Hello world!` Since its a GenericMessageEvent, it will also respond when private messaged. Congratulations, you just wrote your first bot!

PircBotX can do so much more! [Read the docs for more information](http://github.com/TheLQ/pircbotx/wiki/Documentation)

## Support

[Most answers can be found in the docs](http://github.com/TheLQ/pircbotx/wiki/Documentation), javadocs (http://thelq.github.io/pircbotx/latest/apidocs/) and [the wiki](http://github.com/TheLQ/pircbotx/wiki/)

If you can't find an answer, ask on IRC at irc.freenode.net/#pircbotx . [We also have a mailing list](http://groups.google.com/group/pircbotx)

## License 
This project is licensed under GNU GPL v3 to be compatible with the PircBot license. 

It is assumed that commercial users can buy the commercial license of PircBot which grants "modification of the Product's source-code and incorporation of the modified source-code into your software"

The PircBot developer has ignored multiple emails asking for a less restrictive license and clarification of the commercial license. Users can show support by respectfully asking him directly at ![pircbot developer's email](http://thelq.github.io/pircbotx/pircbot-email.gif). More up to date information is available at in Issue #63
