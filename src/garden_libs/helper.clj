(ns garden-libs.helper)


(def screen-true #"screen")
(def screen-only #"only screen")
(def min-width #"min-width: (\S+)\)")
(def max-width #"max-width: (\S+)\)")
(defn at-media-str->map
  [s]
  (merge {}
         (when (re-find screen-true s)
           {:screen true})
         (when (re-find  screen-only s)
           {:screen :only})
         (when-let [m (re-find  min-width s)]
           {:min-width (second m)})
         (when-let [m (re-find  max-width s)]
           {:max-width (second m)})
         ))

(defn fixed-at-media
  [q & more]
  (apply garden.stylesheet/at-media
   (at-media-str->map q)
   more))

(comment

  (at-media-str->map
   "screen and (min-width: 769px)"
)
  (garden.stylesheet/at-media
   "screen and (min-width: 769px) and (max-width: 999px)"
   [".is-flex-tablet-only" {:display "flex !important"}])

  (fixed-at-media
   "screen and (min-width: 769px) and (max-width: 999px)"
   [".is-flex-tablet-only" {:display "flex !important"}])

  )
