(ns deprecated-blowfish
  (:import [javax.crypto Cipher]))

(defn vulnerable []
  (Cipher/getInstance "blowfish/CBC/PKCS5Padding"))

(defn not-vulnerable []
  (Cipher/getInstance "RSA/CBC/PKCS1Padding"))
