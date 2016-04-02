# cljs-om-thing

A project to see how easy it is to use Clojure code within a ClojureScript app.

@AgileGeek wrote a [ChequeParser](https://github.com/chrishowejones/cheque-parser) app in Clojure that converts a numeric number into text description of that number.  This library was converted to ClojureScript by copying the code into a file with a `.cljs` extension.  A simple ClojureScript app was created using Om and the namespace of the CheckParser code was then including in the project.

No code needed to be changed from the ChequeParser.

## Development

Open a terminal and type `lein repl` to start a Clojure REPL
(interactive prompt).

In the REPL, type

```clojure
(run)
(browser-repl)
```

The call to `(run)` does two things, it starts the webserver at port
10555, and also the Figwheel server which takes care of live reloading
ClojureScript code and CSS. Give them some time to start.

Running `(browser-repl)` starts the Weasel REPL server, and drops you
into a ClojureScript REPL. Evaluating expressions here will only work
once you've loaded the page, so the browser can connect to Weasel.

When you see the line `Successfully compiled "resources/public/app.js"
in 21.36 seconds.`, you're ready to go. Browse to
`http://localhost:10555` and enjoy.

**Attention: It is not longer needed to run `lein figwheel`
  separately. This is now taken care of behind the scenes**

## Trying it out

If all is well you now have a browser window saying 'Hello Chestnut',
and a REPL prompt that looks like `cljs.user=>`.

Open `resources/public/css/style.css` and change some styling of the
H1 element. Notice how it's updated instantly in the browser.

Open `src/cljs/cljs-om-thing/core.cljs`, and change `dom/h1` to
`dom/h2`. As soon as you save the file, your browser is updated.

In the REPL, type

```
(ns cljs-om-thing.core)
(swap! app-state assoc :text "Interactivity FTW")
```

Notice again how the browser updates.

## Deploying to Heroku

This assumes you have a
[Heroku account](https://signup.heroku.com/dc), have installed the
[Heroku toolbelt](https://toolbelt.heroku.com/), and have done a
`heroku login` before.

``` sh
git init
git add -A
git commit
heroku create
git push heroku master:master
heroku open
```

## Running with Foreman

Heroku uses [Foreman](http://ddollar.github.io/foreman/) to run your
app, which uses the `Procfile` in your repository to figure out which
server command to run. Heroku also compiles and runs your code with a
Leiningen "production" profile, instead of "dev". To locally simulate
what Heroku does you can do:

``` sh
lein with-profile -dev,+production uberjar && foreman start
```

Now your app is running at
[http://localhost:5000](http://localhost:5000) in production mode.

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

## Chestnut

Created with [Chestnut](http://plexus.github.io/chestnut/) 0.7.0.
