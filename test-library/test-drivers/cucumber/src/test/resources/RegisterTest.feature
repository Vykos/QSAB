# language: sv
Egenskap: Kundregistrering
  Kunder måste registrera sig innan de kan använda tjänsten.

Scenario: Registrering
    Givet en kund med förnamnet "Test", efternamnet "Testsson", personnumret "121212-1212", som bor på gatan "Testgatan 55" med postnummer "12345" och orten "Testort", har telefonnumret "08-123456", mobilnumret "073-123456", mejladressen "test@test.com" och använder lösenordet "123456".
    När kunden fyller i registreringsformuläret och klickar "Nästa".
    Så skapas en ny kund med ovanstående information.

Scenario: Logga in
    Givet en kund med personnumret "121212-1212" och lösenordet "123456".
    När kunden försöker logga in.
    Så lyckas han.

Scenario: Registrering med personnummerbugg
    Givet en kund med förnamnet "Test", efternamnet "Testsson", personnumret "1212-121212", som bor på gatan "Testgatan 55" med postnummer "12345" och orten "Testort", har telefonnumret "08-123456", mobilnumret "073-123456", mejladressen "test@test.com" och använder lösenordet "123456".
    När man väljer buggen "Formateringsfel i personnummer" och kunden fyller i registreringsformuläret och klickar "Nästa".
    Så skapas en ny kund med ovanstående information.

Scenario: Logga in med kund skapad med personnummerbugg
    Givet en kund med personnumret "1212-121212" och lösenordet "123456".
    När kunden försöker logga in.
    Så lyckas han.

Scenario: Städning av databas
    Givet en kund med förnamnet "Test", efternamnet "Testsson", personnumret "121212-1212", som bor på gatan "Testgatan 55" med postnummer "12345" och orten "Testort", har telefonnumret "08-123456", mobilnumret "073-123456", mejladressen "test@test.com" och använder lösenordet "123456".
    När kunden raderas.
    Så finns han inte längre kvar i databasen.

Scenario: Städning av databas med personnummerbugg
    Givet en kund med förnamnet "Test", efternamnet "Testsson", personnumret "1212-121212", som bor på gatan "Testgatan 55" med postnummer "12345" och orten "Testort", har telefonnumret "08-123456", mobilnumret "073-123456", mejladressen "test@test.com" och använder lösenordet "123456".
    När kunden raderas.
    Så finns han inte längre kvar i databasen.