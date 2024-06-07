
        const tryRequire = (path) => {
        	try {
        	const image = require(`${path}`);
        	return image
        	} catch (err) {
        	return false
        	}
        };

        export default {
        
	questionMark: require('./questionMark.png'),
	Cadastro_background: tryRequire('./Cadastro_background.png') || require('./questionMark.png'),
	Cadastro_Line8: tryRequire('./Cadastro_Line8.png') || require('./questionMark.png'),
	Cadastro_Line8_1: tryRequire('./Cadastro_Line8_1.png') || require('./questionMark.png'),
	Cadastro_Line8_2: tryRequire('./Cadastro_Line8_2.png') || require('./questionMark.png'),
	Cadastro_Line8_3: tryRequire('./Cadastro_Line8_3.png') || require('./questionMark.png'),
	Cadastro_Line8_4: tryRequire('./Cadastro_Line8_4.png') || require('./questionMark.png'),
	Cadastro_Line8_5: tryRequire('./Cadastro_Line8_5.png') || require('./questionMark.png'),
	Cadastro_Line9: tryRequire('./Cadastro_Line9.png') || require('./questionMark.png'),
	Cadastro_logoimage: tryRequire('./Cadastro_logoimage.png') || require('./questionMark.png'),
}