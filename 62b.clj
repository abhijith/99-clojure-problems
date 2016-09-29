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
  (let [[elem left right] tree]
    (if (node? tree)
      (when-not (leaf? tree)
        (do
          (println elem)
          (when (= level depth)
            (reset! acc (conj @acc elem)))
          (traverse left  level (inc depth) acc)
          (traverse right level (inc depth) acc))))
    (deref acc)))

(defn collect-internal [tree level]
  (traverse tree level 1 (atom [])))

(collect-internal t1 1) ; [:a :b :c :d]
(collect-internal t2 3) ; [:a :b :c :d e]
