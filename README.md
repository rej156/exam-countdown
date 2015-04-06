# exam-countdown Re-frame App

---

Fork of faheempatel/exam-countdown for QMUL CS Third years

## How to run

Run "`lein figwheel`" in a terminal to compile the app. Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

Any changes to ClojureScript source files (in `src`) will be reflected in the running page immediately (while "`lein figwheel`" is running).

Run "`lein clean; lein with-profile prod compile`" to compile an optimized version.

Original reagent example code found at https://github.com/reagent-project/reagent

---

OR

lein repl > (start-figwheel)

This starts a browser-repl session and figwheel instance too.

Note please edit env/dev/cljs/exam_countdown/dev.cljs IP value to localhost

I am coding this on a cloud ubuntu droplet at the current time.
