'use strict';

var gulp = require('gulp');

require('gulp-stats')(gulp);
var sequence    = require('gulp-sequence');
var bowerFiles  = require('main-bower-files');
var clean       = require('gulp-clean');
var jshint      = require('gulp-jshint');
var less        = require('gulp-less');
var concat      = require('gulp-concat');
var ngAnnotate  = require('gulp-ng-annotate');
var uglify      = require('gulp-uglify');
var ngHtml2Js   = require('gulp-ng-html2js');

var jsFiles     = 'resources/js/**/*.js';
var index       = 'resources/index.html';
var views       = 'resources/js/**/*.html';
var lessFiles   = 'resources/**/*.less';
var lessFile    = 'resources/pd.less';
var webappTargetDirectory = '.';

var jsHintOptions = {
    bitwise: true,
    maxdepth: 4,
    sub: true,
    strict: true,
    undef: true,
    unused: true,
    curly: true,
    eqeqeq: true,
    eqnull: true,
    browser: true,
    newcap: false,
    globals: {
        jQuery: true,
        $: true,
        console: true,
        angular: true,
        Logger: true,
        moment: true,
        sprintf: true,
        _: true,
        _contextPath: true
    }
};

var cleaner = function () {
    return gulp
        .src(["./resources/dist", "./resources/vendor"])
        .pipe(clean({ force: true }));
};

var linter = function() {
    return gulp
        .src(jsFiles)
        .pipe(jshint(jsHintOptions))
        .pipe(jshint.reporter('default'));
};

var viewsConverter = function () {
    gulp.src(views)
        .pipe(ngHtml2Js({
            moduleName: 'pd.views',
            rename: function (templateUrl) {
                var filePathParts = templateUrl.split('/');
                return '/views/' + filePathParts[filePathParts.length - 1];
            }
        }))
        .pipe(concat('pd-views.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest(webappTargetDirectory + '/resources/dist/'));
};

var lesser = function () {
    return gulp
        .src(lessFile)
        .pipe(less())
        .pipe(gulp.dest(webappTargetDirectory + '/resources/dist'));
};

var dist = function () {
    var stream = gulp.src(jsFiles)
        .pipe(concat('pd.js'))
        .pipe(ngAnnotate({ 'single_quotes': true }));

    stream.pipe(gulp.dest(webappTargetDirectory + '/resources/dist/'));
};

var dependencies = function () {
    var js = bowerFiles().filter(onlyJS);
    var css = bowerFiles().filter(onlyCSS);

    var stream = gulp.src(js)
        .pipe(concat('vendors.min.js'));

    stream.pipe(gulp.dest(webappTargetDirectory + '/resources/lib/'));

    gulp.src(css)
        .pipe(concat('vendors.css'))
        .pipe(gulp.dest(webappTargetDirectory + '/resources/lib/'));
};

var filterByExtension = function (file, extension) {
    return file.indexOf('.' + extension) !== -1;
};

var onlyJS = function (file) {
    return filterByExtension(file, 'js');
};

var onlyCSS = function (file) {
    return filterByExtension(file, 'css');
};

gulp.task('clean', cleaner);
gulp.task('lint', linter);
gulp.task('js', dist);
gulp.task('vendor-js', dependencies);
gulp.task('views2js', viewsConverter);
gulp.task('less', lesser);

gulp.task('watch', function () {
    gulp.watch(lessFiles,   ['less']);
    gulp.watch(jsFiles,     ['lint', 'js']);
    gulp.watch(views,       ['views2js']);
});

gulp.task('default', sequence(
    'clean',
    ['lint'],
    ['less', 'views2js', 'js'],
    'vendor-js')
);
