(ns exam-countdown.views.nav
  (:require [re-frame.db :refer [app-db]]
   [re-frame.core :refer [subscribe dispatch]]))

(defn jquery-dropdown-activate []
  (-> (js/$ ".button-collapse")
      (.sideNav {:menuWidth 300
                 :edge "left"
                 :closeOnClick false})))

(defn navbar-item [exam]
  (let [selected? (subscribe [:exam-selected? exam])]
    (fn []
      [(if @selected?
         :li.active
         :li)
       [:a {:href "#"
            :on-click #(dispatch [:select-exam exam])} exam]])))

(defn nav []
  (let [x 1]
    (fn []
      [:div.navbar
       [:nav
        [:a.button-collapse.show-on-large {:href "#"
                                           :on-click #(jquery-dropdown-activate)
                                           :data-activates "slide-out"
                                           :style {:left "5px"
                                                   :height "100%"}}
         [:i.mdi-navigation-menu]]
        [:ul.side-nav {:id "slide-out"}
         (for [exam (:exams @app-db)]
           ^{:key exam}
           [navbar-item (:title exam)])]]])))
