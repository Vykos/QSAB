# language: sv
Egenskap: Kundregistrering
  Kunde måste registrera sig innan de kan använda tjänsten.

Scenario: Registrering
    Givet en kund med förnamnet "Test", efternamnet "Testsson", personnumret "121212-1212", som bor på gatan "Testgatan 55" med postnummer "12345" och orten "Testort", har telefonnumret "s08-123456", mobilnumret "073-123456", mejladressen "test@test.com" och använder lösenordet "123456".
    När kunden fyller i registreringsformuläret och klickar "Nästa".
    Så skapas en ny kund med ovanstående information.