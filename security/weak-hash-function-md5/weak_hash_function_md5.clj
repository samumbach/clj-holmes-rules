(ns weak-hash-function-md5
  (:import (java.security MessageDigest)
           (org.apache.commons.codec.binary Hex)))

(defn hash-vulnerable [s]
  (let [md (MessageDigest/getInstance "MD5")]
    (.update md (.getBytes s))
    (Hex/encodeHexString (.digest md))))

(defn hash-not-vulnerable [s]
  (let [md (MessageDigest/getInstance "SHA-256")]
    (.update md (.getBytes s))
    (Hex/encodeHexString (.digest md))))
