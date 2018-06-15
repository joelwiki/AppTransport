#include "mainwindow.h"
#include <QApplication>
#include "horaires.h"

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    MainWindow w;
    w.show();


   Horaires* horaires = new Horaires(); //On appelle la classe Horaires
   horaires->Debug("démarrage de l'applciation");



    return a.exec();
}
