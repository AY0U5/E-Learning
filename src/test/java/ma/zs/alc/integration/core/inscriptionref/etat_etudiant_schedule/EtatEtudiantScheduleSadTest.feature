Feature: EtatEtudiantSchedule

  Background:
    #* call read('karate-config.js')
    #* call read('db_cleaner.js')

    * url etatEtudiantScheduleUrl
    * header Content-Type = 'application/json'

    * def postBody = read('EtatEtudiantScheduleSave.json')
    * def FindAllSchema = read('EtatEtudiantScheduleSchema.json')
    * def uuid = function() { return '' + java.util.UUID.randomUUID(); }
    * postBody.libelle = uuid()

  @duplicate
  Scenario Outline: POST EtatEtudiantSchedule Twice with same libelle - expect <responseCode> as response code
    * postBody.code = uniqueId
    * def count = db.readValue('select count(*) FROM item.etat_etudiant_schedule')

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * request postBody
    * method POST
    * status <responseCode>
    * eval if(__num==1 && count != db.readValue('select count(*) FROM etat_etudiant_schedule')) karate.fail("etat_etudiant_schedule count values in DB are different")

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
  Scenario: Fail - POST EtatEtudiantSchedule without Body
    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method POST
    * status 400
    * match response.error == "Bad Request"


  @saveWithoutAuthorization
  Scenario: Fail - POST EtatEtudiantSchedule without Authorization
    * path ''
    * header Authorization = 'Bearer unvalid'
    * request postBody
    * method POST
    * status 401


  @saveWithPatchMethod
  Scenario: Fail - Save EtatEtudiantSchedule with method PATCH
    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method PATCH
    * status 405
    * match response.error == "Method Not Allowed"
