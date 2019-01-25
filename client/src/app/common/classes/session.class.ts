import {User} from '../models/user.model';

export class Session {
    login: boolean;
    user: User;

    constructor(init?: User) {
      this.login = (!!init);
      this.user = (init) ? new User(init.userCd, init.userPass, init.userName, init.useYn, init.email) : new User();
    }

    reset(): Session {
      this.login = false;
      this.user =  new User();
      return this;
    }
}
