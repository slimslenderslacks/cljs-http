(defproject com.atomist/cljs-http "0.0.2"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [cljs-node-io "0.5.0"]
                 [noencore "0.1.16"]
                 [metosin/spec-tools "0.6.1"]
                 [org.clojure/test.check "0.10.0-alpha2"]
                 ]

  :plugins [[lein-cljsbuild "1.1.5"]]

  :profiles {:dev {:dependencies [[cider/piggieback "0.3.1"]
                                  [org.clojure/tools.nrepl "0.2.13"]
                                  [tubular "1.0.0"]]
                   :source-paths ["dev"]
                   :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]
                                  :init-ns user}}}
  :clean-targets
  [[:cljsbuild :builds 0 :compiler :output-to]
   [:cljsbuild :builds 0 :compiler :output-dir]
   :target-path
   :compile-path]
  :cljsbuild {:builds [{:id "prod"
                        :source-paths ["src"]
                        :compiler {:main atomist.main
                                   :target :nodejs
                                   :output-to "main.js"
                                   :output-dir "out"
                                   :externs ["externs.js"]
                                   :optimizations :simple
                                   :pretty-print true
                                   :parallel-build true}}]})
