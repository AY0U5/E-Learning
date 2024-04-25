Feature: TrancheHoraireProf

  Background:
    #* call read('karate-config.js')
    #* call read('db_cleaner.js')

    * url trancheHoraireProfUrl
    * header Content-Type = 'application/json'

    * def postBody = read('TrancheHoraireProfSave.json')
    * def FindAllSchema = read('TrancheHoraireProfSchema.json')

  @getByIdNotFound
  Scenario: Fail - GetByID Not Found
    * path 'id', 99999999
    * header Authorization = 'Bearer ' + adminToken
    * method GET
    * status 404
    * match response.length == 0


  @saveWithoutBody
  Scenario: Fail - POST TrancheHoraireProf without Body
    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method POST
    * status 400
    * match response.error == "Bad Request"


  @saveWithoutAuthorization
  Scenario: Fail - POST TrancheHoraireProf without Authorization
    * path ''
    * header Authorization = 'Bearer unvalid'
    * request postBody
    * method POST
    * status 401


  @saveWithPatchMethod
  Scenario: Fail - Save TrancheHoraireProf with method PATCH
    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method PATCH
    * status 405
    * match response.error == "Method Not Allowed"