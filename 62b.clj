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

(defn traverse [tree level depth acc]
  (let [[elem left right] tree d (inc depth)]
    (if (node? tree)
      (when-not (leaf? tree)
        (do
          (println elem)
          (when (= level depth)
            (reset! acc (conj @acc elem)))
          (when-not (> d level)
            (traverse left  level d acc)
            (traverse right level d acc)))))
    (deref acc)))

(defn collect-internal [tree level]
  (traverse tree level 1 (atom [])))

(collect-internal t1 1) ; [:a :b :c :d]
(collect-internal t2 2) ; [:a :b :c :d e]
