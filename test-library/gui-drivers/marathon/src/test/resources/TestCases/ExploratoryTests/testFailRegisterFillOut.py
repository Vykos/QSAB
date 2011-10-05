#{{{ Marathon
from default import *
#}}} Marathon

def test():

    set_java_recorded_version("1.6.0_26")
    if window('Quality Spa AB'):
        click('welcome_superadmin')
        select('superadmin_glitchlist', '[{0, true}]')
        click('superadmin_accept')
        click('welcome_register')
        select('field_F\xf6rnamn', 'Test')
        select('field_Efternamn', 'Testsson')
        select('field_Personnummer', '1212-121212')
        select('field_Postadress', 'Testgatan 55')
        select('field_Postnummer', '12345')
        select('field_Ort', 'Testort')
        select('field_Hemtelefon', '08-123456')
        select('field_Mobil', '073-123456')
        select('field_E-postadress', 'test@test.com')
        select('field_L\xf6senord', '123456')
        select('field_Upprepa l\xf6senord', '123456')
        click('register_next')
        click('register_previous')
        click('register_previous')
        click('welcome_login')
        select('field_Personnummer', '1212-121212')
        select('field_L\xf6senord', '123456')
        click('login_next')
        window_closed('Quality Spa AB')
    close()

    pass