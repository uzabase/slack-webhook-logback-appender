(ns slack-appender.core
  (:require [clj-http.client :as http]
            [cheshire.core :refer [generate-string]])
  (:gen-class
   :name com.uzabase.logback.appender.SlackAppender
   :state fields
   :init  init
   :extends ch.qos.logback.core.AppenderBase
   :methods [[setUrl [String] void]
             [getUrl [] String]]))

(defn -init
  []
  [[] (atom {})])

(declare -getUrl)

(defn -append
  [this event]
  (let [url (-getUrl this)
        message (.getMessage event)
        payload (generate-string {:text message})]
    (http/post url {:form-params {:payload payload}})))

(defn -setUrl
  [this url]
  (let [state (.fields this)]
    (swap! state update :url (fn [_] url))))

(defn -getUrl
  [this]
  (:url @(.fields this)))
