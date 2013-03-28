javac -cp . serveur/*.java
rmic -classpath . serveur.TchatServeur
rmic -classpath . serveur.NewFrame
start rmiregistry
start java -cp . serveur.TchatServeur
java -cp . serveur.NewFrame
