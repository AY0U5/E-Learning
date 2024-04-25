Feature: EtatInscription

  Background:
    #* call read('karate-config.js')
    #* call read('db_cleaner.js')

    * url etatInscriptionUrl
    * header Content-Type = 'application/json'

    * def postBody = read('EtatInscriptionSave.json')
    * def FindAllSchema = read('EtatInscriptionSchema.json')
    * def uuid = function() { return '' + java.util.UUID.randomUUID(); }
    * postBody.libelle = uuid()

  @duplicate
  Scenario Outline: POST EtatInscription Twice with same libelle - expect <responseCode> as response code
    * postBody.code = uniqueId
    * def count = db.readValue('select count(*) FROM item.etat_inscription')

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * request postBody
    * method POST
    * status <responseCode>
    * eval if(__num==1 && count != db.readValue('select count(*) FROM etat_inscription')) karate.fail("etat_inscription count values in DB are different")

    Examples:
      | responseCode |
      | 201          |
      | 226          |

  @getByIdNotFound
  Scenario: Fail - GetByID Not Found
    * path 'id', 99999999
    * header Authorization = 'Bearer ' + adminToken
    * method GET
    * status 404
    * match response.length == 0


  @saveWithoutBody
  Scenario: Fail - POST EtatInscription without Body
    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method POST
    * status 400
    * match response.error == "Bad Request"


  @saveWithoutAuthorization
  Scenario: Fail - POST EtatInscription without Authorization
    * path ''
    * header Authorization = 'Bearer unvalid'
    * request postBody
    * method POST
    * status 401


  @saveWithPatchMethod
  Scenario: Fail - Save EtatInscription with method PATCH
    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method PATCH
    * status 405
    * match response.error == "Method Not Allowed"
