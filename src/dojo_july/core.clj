(ns dojo-july.core
  (:use compojure.core
        hiccup.core
        hiccup.page-helpers
        hiccup.form-helpers)
  (:require
   [compojure.route :as route]
   [compojure.handler :as handler]))

(defn get-signup []
  (html [:h1 "Welcome to Team 4's Signup"]
        [:form {:method "post" :action "/signup"}
         (text-field "name" "Your name here")
         (text-field "email" "Your email here")
         (submit-button "Sign up!")]))

(defn post-signup [name email]
  (html [:h1 "Thanks for signing up!"]
        [:p (str "You're signed up as"
                 name
                 "with email "
                 email)]))

(defroutes main-routes
  (GET "/signup" [] (get-signup))
  (POST "/signup" [name email]
        (post-signup name email)))

(def app (handler/site main-routes))