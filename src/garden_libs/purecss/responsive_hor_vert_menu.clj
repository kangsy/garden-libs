(ns garden-libs.purecss.responsive-hor-vert-menu
  (:require
   [garden.def :refer [defstyles]]
   [garden.core :refer [css]]
   [garden.units :refer [em px]]
   [garden.stylesheet :refer [at-media at-import]]
   [garden.color :as color :refer [rgb]]
                                        ; [css.purecss.core :as purecss]
   ))

(garden.def/defcssfn translateY)
(garden.def/defcssfn rotate)
(garden.def/defstyles horizontal-vertical
  [".custom-wrapper" {:margin-bottom "1em"} {:transition "height 0.5s"}]
  [".custom-wrapper.open" {:height "14em"}]
  [".custom-menu-3" {:text-align "right"}]
  [".custom-toggle" {:width "34px"} {:height "34px"} {:display "block"} {:position "absolute"} {:top "0"} {:right "0"} {:display "none"}]
  [".custom-toggle .bar" {:background-color "#777"} {:display "block"} {:width "20px"} {:height "2px"} {:border-radius "100px"} {:position "absolute"} {:top "18px"} {:right "7px"} {:transition "all 0.5s"}]
  [".custom-toggle .bar:first-child" {:transform (translateY (garden.units/px -6))}]
  [".custom-toggle.x .bar" {:transform (rotate (garden.units/deg 45))}]
  [".custom-toggle.x .bar:first-child" {:transform (rotate (garden.units/deg -45))}]
  (garden.stylesheet/at-media {:max-width "47.999em"} [".custom-menu-3" {:text-align "left"}] [".custom-toggle" {:display "block"}]))

(css {:output-to "resources/pure-css-custom-menu.css"} horizontal-vertical  )
