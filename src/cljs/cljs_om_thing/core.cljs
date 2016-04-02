(ns cljs-om-thing.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [cljs-om-thing.cheque-parser :as cheque]))


(defonce app-state (atom {:heading "Hello Clojure Chestnut!"
                          :sub-heading "Do you want to play a game"
                          :answer "Lets play global themo-nuclear war"
                          :cheque-number 999}))

(defn handle-change [e app]
  (let [value (.. e -target -value)]
    (if (re-find #"[0-9]" value)
      (om/update! app :cheque-number value)
      (om/update! app :cheque-number (app :cheque-number))
      )
    (.preventDefault e)))

(defn main []
  (om/root
    (fn [app owner]
      (reify
        om/IRender
        (render [_]
          (dom/div nil
            (dom/input #js {:type "number"
                            :value (:cheque-number app)
                            :onChange #(handle-change % app)})
            (dom/p nil (cheque/convert (js/parseInt (:cheque-number app))))))))
    app-state
    {:target (. js/document (getElementById "app"))}))
