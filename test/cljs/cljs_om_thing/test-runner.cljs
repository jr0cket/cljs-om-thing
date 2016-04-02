(ns cljs_om_thing.test-runner
  (:require
   [cljs.test :refer-macros [run-tests]]
   [cljs_om_thing.core-test]))

(enable-console-print!)

(defn runner []
  (if (cljs.test/successful?
       (run-tests
        'cljs_om_thing.core-test))
    0
    1))
