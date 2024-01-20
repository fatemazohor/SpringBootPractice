class Cart{
    constructor(cartName) {
        this.cartName=cartName
    }
    //method get cat start

    getCart(){
        let cart=localStorage.getItem(this.cartName);
        cart=JSON.parse(cart);
        return cart;

    }
    //method get cat end
    //method QuantityAdd start
    QtyUp(id,qty){
        let cart=localStorage.getItem(this.cartName);
        if(cart !=null){
            cart=JSON.parse(cart);
            let tmp=[];

            cart.forEach(function (item,i) {
                if (id == item.item_id){
                    let discount=item.discount != null?item.discount:0;
                    item.qty+=qty;
                    if (item.qty < 1){item.qty = 1}

                    discount= item.discount;
                    item.total_discount = item.discount * item.qty;
                    item.subtotal = (item.qty * item.price) -discount;
                    tmp.push(item);

                }else{
                    tmp.push(item);
                }
            });
            localStorage.setItem(this.cartName,JSON.stringify(tmp));
        }
    }
    //method QuantityAdd end
    //method itemExist start
    itemExists(id){
        let found=0;
        let cart = localStorage.getItem(this.cartName);
        if (cart != null){
            cart = JSON.parse(cart);

            //for each for all table row
            cart.forEach(function (item,i){
                if(id==item.item_id){
                    found=1;
                }
            })

        }else{
            found=0;
        }
        return found;
    }
    //method itemExist end
    //method save Cart start
    save(item){
        let cart =localStorage.getItem(this.cartName);
        if (cart !=null){
            if(! this.itemExists(item.item_id)){
                cart=JSON.parse(cart);
                cart.push(item);
                localStorage.setItem(this.cartName,JSON.stringify(cart));
            }else {
                this.QtyUp(item.item_id,item.qty)
            }
        }else {
            cart=[];
            cart.push(item);
            localStorage.setItem(this.cartName,JSON.stringify(cart))
        }
    }

    //method save Cart end
    //delete method
    delItem(id){
        let cart = localStorage.getItem(this.cartName);
        if (cart != null){
            cart = JSON.parse(cart);
            let tmp=[];

            cart.forEach(function (item,i){
                if(id != item.item_id){
                    tmp.push(item);
                }
            });
            localStorage.setItem(this.cartName,JSON.stringify(tmp));
        }
    }
    //delete methodend
    //clear method
    clearCart(){
        localStorage.removeItem(this.cartName);
        localStorage.setItem(this.cartName,JSON.stringify([]))
    }
    //clear method end

}