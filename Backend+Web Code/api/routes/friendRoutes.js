  /* Created by Manjeet Singh
 17 Oct'17
 */

'use strict';
module.exports = function(app) {
  var friendList = require('../controllers/friendControllers');

  app.route('/friends/add_friend').post(friendList.create_a_friend);
  app.route('/friends/get_friends/:user').get(friendList.list_all_friends);
  app.route('/friends/getHome/').get(friendList.get_home);
  app.route('/friends/get_friend_by_id/:friendId&:user').get(friendList.read_a_friend);
  app.route('/friends/update_friend/:friendId').put(friendList.update_a_friend);
  app.route('/friends/delete_friend/:friendId').delete(friendList.delete_a_friend);
  app.route('/friends/find_by_initial/:initi&:user').get(friendList.find_by_initial);
  app.route('/friends/find_by_name/:name').get(friendList.find_by_name);
  app.route('/friends/add_token').post(friendList.create_a_token);
  app.route('/friends/get_token/:token').get(friendList.read_a_token);
  app.route('/friends/get_mail/:mail').get(friendList.read_a_mail);
  app.route('/friends/').get(friendList.welcome);
  app.route('/friends/find_recent/:user').get(friendList.find_recent);



};
