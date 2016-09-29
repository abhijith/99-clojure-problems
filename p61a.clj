(def t1 [:a
         [:b [:b1 nil nil] [:b2 nil nil]]
         [:c
          [:d [:d1 nil nil] [:d2 nil nil]]
          nil]])

(def t2 [:a
         [:b
          [:b1 nil nil]
          [:b2 nil nil]]
         [:c
          [:d
           [:d1 nil nil]
           [:d2 nil nil]]
          [:e
           nil
           [:e1 nil nil]]]])

(defn node? [x]
  (when-not (nil? x)
    (and (coll? x)
         (= 3 (count x)))))

(defn leaf? [node]
  (let [[elem left right] node]
    (and (nil? left) (nil? right))))

(leaf? t1) ; false
(leaf? (get-in t1 [2 1 1])) ; true

(defn traverse [tree acc]
  (let [[elem left right] tree]
    (if (node? tree)
      (if (leaf? tree)
        (reset! acc (conj @acc elem))
        (do (traverse left acc)
            (traverse right acc))))
    (deref acc)))

(defn collect-leaves [tree]
  (traverse tree (atom [])))

(collect-leaves t1) ; [:b1 :b2 :d1 :d2]
(collect-leaves t2) ; [:b1 :b2 :d1 :d2 :e1]
