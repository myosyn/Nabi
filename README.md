# Nabi 나비
Nabi is a stability driven Discord bot that strives for modern features as well as being completely free. There is absolutely no catch when it comes to this. Yes, all of 
the features are completely free, and come straight from the creator's pockets. We want to prove that JVM languages are the future for Discord bots.

The main purpose of this bot is to provide modern moderation, phishing detection, and other features that will be introduced later down the line. We could possibly make
it a music bot as well, but no.

The main libraries that we used are the [Kord Library](https://github.com/kordlib/kord) and the extension [Kord Extension](https://github.com/Kord-Extensions/kord-extensions) .

Also turn on git-hooks because apparently it breaks if there are any detectable errors, and will completely fail your commit. I almost ripped my hair out trying to solve the problem. I tried downgrading gradle and rewriting everything so it'd work, but no. Git-hooks is dead to me now so.

TODO: Remove githooks and detekt as dependencies, as they're unneeded. You'll also need to add every single moderation command soon. Don't consider chat commands, the API cuts them in about 2 months.