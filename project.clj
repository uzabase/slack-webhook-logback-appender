(defproject slack-webhook-logback-appender "1.0.0"
  :description "FIXME: write description"
  :url "https://github.com/uzabase/slack-webhook-logback-appender"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "3.4.1"]
                 [cheshire "5.7.0"]
                 [ch.qos.logback/logback-classic "1.2.1"]]
  :aot [slack-appender.core]
  :deploy-repositories [["releases" {:sign-releases false}]])
