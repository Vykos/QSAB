Feature: Kundregistrering
  Kunde m�ste registrera sig innan de kan anv�nda tj�nsten.

Scenario: Registrering
    Givet en kund med f�rnamnet Test, efternamnet Testsson, personnumret 121212-1212, som bor p� gatan Testgatan 55 med postnummer 12345 och orten Testort, har telefonnumret 08-123456, mobilnumret 073-123456, mejladressen test@test.com och anv�nder l�senordet 123456.
    N�r kunden fyller i registreringsformul�ret och klickar "N�sta".
    S� skapas en ny kund med ovanst�ende information.